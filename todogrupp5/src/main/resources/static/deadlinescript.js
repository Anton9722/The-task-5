var deadlineElements = document.getElementsByClassName("deadlines");
var currentDate = new Date();

Array.from(deadlineElements).forEach(function (element) {
  var thTextValue = element.innerHTML;
  var deadline = new Date(thTextValue);
  var timeDiff = Math.abs(deadline.getTime() - currentDate.getTime());
  var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
  var diffDaysPassed = Math.ceil(timeDiff / (1000 * 3600 * 24)-1);

  if (deadline < currentDate) {
    element.innerHTML = "Deadline: " + deadline.toLocaleDateString() + " och har passerat med " + diffDaysPassed + " dagar";
    element.classList.add("red-background");
  } else {
    element.innerHTML = "Deadline: " + deadline.toLocaleDateString() + " och är " + diffDays + " dagar kvar";
    element.classList.add("green-background");
  }
});


document.getElementById('taskForm').addEventListener('submit', function(event) {
  var taskDeadline = document.getElementById('taskDeadline').value;
  if (!taskDeadline) {
      alert('Du måste fylla i ett datum.');
      event.preventDefault();
  }
});