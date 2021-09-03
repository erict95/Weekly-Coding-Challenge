//The test number
const num = 123456;
/*The function that will compute the additive persistence through recursion
*/
const additive = (num, sum = 0) => {
   if(num){
       while(Math.floor(num / 10)){
            sum += (num % 10);
            num = Math.floor(num / 10);
       }
       sum += (num % 10);
    //   return additive(Math.floor(num / 10), sum + num % 10);
   };
   return sum;
};
//The function that will recursively compute the multiplicative persistence
const multiply = (num, multi = 1) => {
    if(num){
        return multiply(Math.floor(num / 10), multi * (num % 10));
     };
     return multi;
};
//This function will call the additive and multiplicative functions
const persistence = num => {
   num = Math.abs(num);
   let num2 = num;
   let count = 0;
   let count2 = 0;
   while(num > 9){
      num = additive(num);
      count++;
   };
   while(num2 > 9){
    num2 = multiply(num2);
    count2++;
 };
   return "The additive is: " + count + "\nand the multiplicative is: " + count2;
};
console.log(persistence(num));