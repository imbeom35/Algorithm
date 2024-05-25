const solution = (book_time) => {
    let rooms = [];
    
    book_time.sort().forEach((item) => {
        let start = timeToNumber(item[0]);
        let end = timeToNumber(item[1]);
        
        if(rooms.length === 0) {
            rooms.push(end + 10);
        } else {
            rooms = rooms.sort();
            let flag = true;
            for(let i=0; i<rooms.length; i++) {
                if(rooms[i] <= start) {
                    rooms[i] = end + 10;
                    flag = false;
                    break;
                }
            }

            if(flag) rooms.push(end + 10);
        }
    });
    
    return rooms.length;
}

const timeToNumber = (time) => {
    let [hour, minute] = time.split(':');
    
    return parseInt(hour) * 60 + parseInt(minute);
}