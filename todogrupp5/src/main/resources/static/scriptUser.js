document.querySelector('form').addEventListener('submit', validatePasswords);

function validatePasswords(event) {
    const password = getPassword();
    const confirmPassword = getConfirmPassword();

    if (passwordsDoNotMatch(password, confirmPassword)) {
        displayPasswordError();
        preventFormSubmission(event);
    }
}

function getPassword() {
    return document.querySelector('input[name="password"]').value;
}

function getConfirmPassword() {
    return document.querySelector('input[name="confirmPassword"]').value;
}

function passwordsDoNotMatch(password, confirmPassword) {
    return password !== confirmPassword;
}

function displayPasswordError() {
    document.getElementById('passwordError').style.display = 'block';
}

function preventFormSubmission(event) {
    event.preventDefault();
}