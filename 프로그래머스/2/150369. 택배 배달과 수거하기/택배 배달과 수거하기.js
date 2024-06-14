const solution = (cap, n, deliveries, pickups) => {
    let answer = 0;
    let deliverySum = 0;
    let pickupSum = 0;
    
    for (let i = n-1; i >= 0; i--) {
        let cnt = 0;
        deliverySum += deliveries[i];
        pickupSum += pickups[i];
        
        while(deliverySum > 0 || pickupSum > 0) {
            deliverySum -= cap;
            pickupSum -= cap;
            cnt++;
        }
        
        answer += (i + 1) * 2 * cnt;
    }
    
    return answer;
}