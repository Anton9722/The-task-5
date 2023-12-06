if (document.getElementById("loginBtn")) {
    console.log("loginBtn found");
    document.getElementById("loginBtn").addEventListener("click", () => {
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;
        console.log("Button clicked");
        console.log(users);
        let userFound = users.find(user => user.username === username && user.password === password);

        if (userFound) {
            localStorage.setItem("adminLoggedIn", userFound.adminLoggedIn.toString()); 
            localStorage.setItem("loggedIn", userFound.loggedIn.toString()); 
        } else {
            alert("Invalid username or password");
        }
    });
}

if (document.getElementById("logoutBtn")) {
    document.getElementById("logoutBtn").addEventListener("click", () => {
        
        let currentUser = users.find(user => user.loggedIn);

        if (currentUser) {
            
            currentUser.loggedIn = false;
            currentUser.adminLoggedIn = false;

            localStorage.setItem("adminLoggedIn", "false"); 
            localStorage.setItem("loggedIn", "false"); 
        } else {
            console.error("User not found");
        }
    });
}

if (document.getElementById("newUserBtn")) {
    document.getElementById("newUserBtn").addEventListener("click", function() {
        window.location.href = "/createuser";
    });
}

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