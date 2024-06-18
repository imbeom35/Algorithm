const solution = (edges, target) => {
    let targetCnt = 0;
    let saveClear = new Set();
    target.forEach((item) => {
        if (item > 0) targetCnt++;
    });
    
    let nodeCnt = 0;
    edges.forEach((item) => {
        nodeCnt = Math.max(nodeCnt, item[0]);
        nodeCnt = Math.max(nodeCnt, item[1]);
    });
    
    let nodeList = Array.from({ length: nodeCnt + 1 }, () => new Array());
    edges.forEach((edge) => {
        nodeList[edge[0]].push(edge[1]);
    });
    
    //자식노드 정렬
    nodeList.forEach((node) => {
        node.sort((a, b) => a - b);
    });
    
    let arrow = new Array(nodeCnt).fill(0); //노드의 화살표 인덱스를 저장
    let nodeNumber = new Array(); //떨어진 순서대로 노드 넘버를 가리킨다
    let numberCnt = new Array(nodeCnt + 1).fill(0); //노드 넘버에 쌓인 숫자의 개수
    
    while (targetCnt) {
        //숫자 떨어뜨리기
        let curr = 1;
        while (nodeList[curr].length > 0) {
            let next = nodeList[curr][arrow[curr]];
            
            //화살표 변경
            if (nodeList[curr].length > 1) {
                if (arrow[curr] < nodeList[curr].length - 1) {
                    arrow[curr]++;
                } else {
                    arrow[curr] = 0;
                }
            }
            
            //다음 노드로 이동
            curr = next;
        }
        nodeNumber.push(curr);
        numberCnt[curr]++;
        
        //target을 초과하는 경우 [-1]반환
        if (target[curr-1] < numberCnt[curr]) return [-1];
        
        //terget을 채우는 경우 카운트
        if (target[curr-1] <= numberCnt[curr] * 3 && !saveClear.has(curr)) {
            saveClear.add(curr);
            targetCnt--;
        }
    }
    
    let answer = [];
    
    nodeNumber.forEach((item) => {
        if ((numberCnt[item] - 1) * 3 >= target[item - 1] - 1) {
            target[item - 1] -= 1;
            answer.push(1);
        } else if ((numberCnt[item] - 1) * 3 >= target[item - 1] - 2) {
            target[item - 1] -= 2;
            answer.push(2);
        } else {
            target[item - 1] -= 3;
            answer.push(3);
        }
        numberCnt[item]--;
    });
    
    return answer;
}