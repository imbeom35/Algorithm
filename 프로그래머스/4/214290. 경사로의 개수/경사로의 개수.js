const MOD = 1000000007n;
const dx = [1, 0, -1, 0];
const dy = [0, 1, 0, -1];

const solution = (grid, d, k) => {
    const n = grid.length;
    const m = grid[0].length;
    const dl = d.length;
    
    //dp[순서][출발지][도착지]
    let dp = new Array(dl + 1).fill(0)
        .map(() => new Array(n * m).fill(0)
        .map(() => new Array(n * m).fill(0n)));
    
    for (let i = 0; i < n * m; i++) {
        dp[0][i][i] = 1n;
    }
    
    for (let l = 1; l <= dl; l++) {
        for (let i = 0; i < n*m; i++) {
            let x = i % m;
            let y = Math.floor(i / m);
            
            for (let dir = 0; dir < 4; dir++) {
                let nx = x + dx[dir];
                let ny = y + dy[dir];
                
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[ny][nx] - grid[y][x] !== d[l-1]) {
                    continue;
                }
                
                for (let j = 0; j < n*m; j++) {
                    dp[l][j][ny*m + nx] += dp[l-1][j][i] % MOD;
                    dp[l][j][ny*m + nx] %= MOD;
                }
            }
        }
    }
    
    //행렬곱 연산 이용
    //k를 count번의 거듭제곱으로 연산 횟수 단축
    let count = 0;
    while (Math.pow(2, count) < k) {
        count++;
    }
    
    //matrixPower[c]는 dp[dl]을 c번 제곱한 행렬
    //dp[dl]: 정해진 순서를 따라 출발지에서 도착지로 가는 경우의 수를 기록한 행렬
    let matrixPower = new Array(count + 1).fill(0)
        .map(() => new Array(n * m).fill(0)
        .map(() => new Array(n * m).fill(0n)));
    
    matrixPower[0] = dp[dl];
    
    for (let c = 1; c <= count; c++) {
        matrixPower[c] = mulMatrix(matrixPower[c-1], matrixPower[c-1]);
    }
    
    //초깃값을 단위 행렬로 세팅
    let mat = new Array(n * m).fill(0).map(() => new Array(n * m).fill(0n));
    for (let i = 0; i < n*m; i++) {
        mat[i][i] = 1n;
    }
    
    //최종적으로 i에서 k번의 순서를 거쳐서 j로 이동하는 경우의 수를 저장하는 행렬 생성
    //k = 2^a + 2^b + 2^c + ... + 1 (a > b > c)
    let kNum = k;
    while (kNum > 0) {
        if (kNum >= Math.pow(2, count)) {
            mat = mulMatrix(mat, matrixPower[count]);
            kNum -= Math.pow(2, count);
        }
        count--;
    }
    
    //모든 경우의 수 더하기
    let answer = 0n;
    for (let i = 0; i < n*m; i++) {
        for (let j = 0; j < n*m; j++) {
            answer += mat[i][j] % MOD;
            answer %= MOD;
        }
    }
    
    return answer;
}
    
const mulMatrix = (a, b) => {
    let n = a.length;
    let result = new Array(n).fill(0)
        .map(() => new Array(n).fill(0n));
    
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            for (let l = 0; l < n; l++) {
                result[i][j] += ((a[i][l] % MOD) * (b[l][j] % MOD)) % MOD;
                result[i][j] %= MOD;
            }
        }
    }
    
    return result;
}