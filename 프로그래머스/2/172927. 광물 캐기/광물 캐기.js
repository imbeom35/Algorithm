const solution = (picks, minerals) => {
    let answer = 0;
    const sortArr = [];
    const fatigue = [
        [1, 1, 1],
        [5, 1, 1],
        [25, 5, 1]
    ];
    const mlen = Math.ceil(minerals.length / 5);
    const plen = picks[0] + picks[1] + picks[2];
    
    for(let i=0; i<mlen; i++) {
        if(i >= plen) break;
        
        const arr = [0, 0, 0];
        
        minerals.splice(0, 5).forEach((item) => {
            switch(item) {
                case 'diamond':
                    arr[0]++;
                    break;
                case 'iron':
                    arr[1]++;
                    break;
                case 'stone':
                    arr[2]++;
                    break;
            }
        });
        
        sortArr.push(arr);
    }
    
    sortArr.sort((a, b) => {
        if(a[0] == b[0]) {
            if(a[1] == b[1]) {
                return b[2] - a[2];
            } else {
                return b[1] - a[1];
            }
        } else {
            return b[0] - a[0];
        }
    });
    
    sortArr.forEach((item) => {
        let idx;
        if(picks[0] != 0) idx = 0;
        else if(picks[1] != 0) idx = 1;
        else if(picks[2] != 0) idx = 2;
        else idx = -1;
        
        if(idx != -1) {
            answer += fatigue[idx][0] * item[0];
            answer += fatigue[idx][1] * item[1];
            answer += fatigue[idx][2] * item[2];
            picks[idx]--;
        }
    });
    
    return answer;
}