var deadlineElements = document.getElementsByClassName("deadlines");

var currentDate = new Date();

Array.from(deadlineElements).forEach(function (element) {
  var thTextValue = element.innerHTML;
  var deadline = new Date(thTextValue);

  if (deadline < currentDate) {
    element.innerHTML = "Deadline har passerat";
  } else {
    var timeDiff = Math.abs(deadline.getTime() - currentDate.getTime());
    var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)); 
    element.innerHTML = diffDays + " dagar kvar";
  }
});

document.getElementById('taskForm').addEventListener('submit', function(event) {
  var taskDeadline = document.getElementById('taskDeadline').value;
  if (!taskDeadline) {
      alert('Du måste fylla i ett datum.');
      event.preventDefault();
  }
});