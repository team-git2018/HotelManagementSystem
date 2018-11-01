var c = [0, 0, 0, 0, 0];
var price;
var countElements = document.getElementsByClassName("count");
var amountPriceElements = document.getElementsByClassName("amountPrice");

function increaseCount(listNumber) {
  c[listNumber] = c[listNumber] + 1;
  countElements[listNumber].innerHTML = c[listNumber];
  calcPrice(listNumber);
}

function decreaseCount(listNumber) {
  if(c[listNumber] > 0) {
    c[listNumber] = c[listNumber] - 1;
    countElements[listNumber].innerHTML = c[listNumber];
    calcPrice(listNumber);
  }
}

function calcPrice(listNumber) {
  if (listNumber == 0) {
    price = 100;
  }
  else if (listNumber == 1) {
    price = 200;
  }
  else if (listNumber == 2) {
    price = 300;
  }
  else if (listNumber == 3) {
    price = 400;
  }
  else if (listNumber == 4) {
    price = 500;
  }
  price = price * c[listNumber];
  amountPriceElements[listNumber].innerHTML = price;
}
