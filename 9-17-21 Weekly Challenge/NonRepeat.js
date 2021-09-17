//Write a function that returns the longest non-repeating substring for a 
//string input.

function NonRepeat(s){
    let output = "";
    for (let x = 0; x < s.length; x++) {
        const spot = new Set();
        let y = x;
        for (; y < s.length; y++) {
            const current = s.charAt(y);
            if (spot.has(current)) {
                break;
            } else {
                spot.add(current);
            }
        }
        if (output.length < y - x + 1) {
            output = s.substring(x, y);
        }
    }
    return output;
}

console.log(NonRepeat("aaababcdefghcc"));
console.log(NonRepeat("happylemon"));
console.log(NonRepeat("hmon"));
console.log(NonRepeat("hapon"));
console.log(NonRepeat("pn"));