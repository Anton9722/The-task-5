var deadlineElements = document.getElementsByClassName("deadlines");

var currentDate = new Date();

Array.from(deadlineElements).forEach(function (element) {
  var thTextValue = element.innerHTML;
  var deadline = new Date(thTextValue);

  if (deadline < currentDate) {
    element.innerHTML = element.innerHTML + " Deadline har passerat";
  } else {
    console.log("det är lungt " + deadline);
  }
});
