let loggedInUser = false;
let formContainer = document.getElementById("form1");
let formContainerUser = document.getElementById("form3"); 
let admin = false;
let loginBtn = document.getElementById("loginBtn");
let username = document.getElementById("username");
let password = document.getElementById("password");

updateHeaderText();
if (formContainerUser) {
    createUserForm();
} else {
    console.log("formContainerUser is null or undefined");
}

if (formContainer && !localStorage.getItem("loggedInUser")) {
    createLoginForm();
} else if (formContainer) {
    createLoggedInForm();    
}

function createUserForm(){
    formContainerUser.innerHTML = ''; 
    const logoutFormUser = document.createElement('form');
    logoutFormUser.method = 'post';
    logoutFormUser.action = '/logout';

    
    const homeBtn = document.createElement('button');
    homeBtn.type = 'button'; 
    homeBtn.id = 'homeBtn';
    homeBtn.textContent = 'Till Startsidan';

    const logoutBtn = document.createElement('button');
    logoutBtn.type = 'submit';
    logoutBtn.id = 'logoutBtn';
    logoutBtn.textContent = 'Logga ut';

    logoutFormUser.appendChild(homeBtn);
    logoutFormUser.appendChild(logoutBtn);
    formContainerUser.appendChild(logoutFormUser);

    logoutFormUser.addEventListener('submit', (event) => {
        event.preventDefault(); 
        localStorage.removeItem('loggedInUser');
        console.log('Logout success');
        window.location.href = '/';
    });

      homeBtn.addEventListener('click', () => {
        window.location.href = '/';
    });


}

function createLoginForm() {
    formContainer.innerHTML = '';

    const loginForm = document.createElement('form');
    loginForm.method = 'post';
    loginForm.action = '/'; 

    const usernameInput = document.createElement('input');
    usernameInput.type = 'text';
    usernameInput.name = 'username';
    usernameInput.id = 'username';
    usernameInput.placeholder = 'Användarnamn';
    usernameInput.required = true;

    const passwordInput = document.createElement('input');
    passwordInput.type = 'password';
    passwordInput.name = 'password';
    passwordInput.id = 'password';
    passwordInput.placeholder = 'Lösenord';
    passwordInput.required = true;

    const loginBtn = document.createElement('button');
    loginBtn.type = 'submit';
    loginBtn.id = 'loginBtn';
    loginBtn.textContent = 'Logga in';

    const newUserBtn = document.createElement('button');
    newUserBtn.type = 'button'; 
    newUserBtn.id = 'newUserBtn';
    newUserBtn.textContent = 'Användare/Skapa ny';

    const loginError = document.createElement('div');
    loginError.id = 'loginError';

    loginForm.appendChild(usernameInput);
    loginForm.appendChild(passwordInput);
    loginForm.appendChild(loginBtn);
    loginForm.appendChild(newUserBtn);
    loginForm.appendChild(loginError);

    formContainer.appendChild(loginForm);

    
    loginForm.addEventListener('submit', (event) => {
        event.preventDefault(); 
        let username = document.getElementById('username').value;
        let password = document.getElementById('password').value;

        let userFound = users.find(user => user.username === username && user.password === password);

        if (userFound) {
            loggedInUser = true;
            localStorage.setItem('loggedInUser', true);
            console.log('Login Success');
            createLoggedInForm();
            updateHeaderText();
        } else if((username === "admin" && password === "admin")) {
            admin = true;
            localStorage.setItem("key1", "admin");
            localStorage.setItem("key2", "admin");
            document.dispatchEvent(new Event('loginStatusChanged'));
            window.location.href = "/adminSida";

        }
        else {
            admin = false;
            loginError.textContent = 'Felaktigt användarnamn eller lösenord';
        }
    });

    newUserBtn.addEventListener('click', () => {
        window.location.href = '/createuser';
    });
}

function createLoggedInForm() {
    formContainer.innerHTML = '';
    const logoutForm = document.createElement('form');
    logoutForm.method = 'post';
    logoutForm.action = '/logout';

    
    const logoutBtn = document.createElement('button');
    logoutBtn.type = 'submit';
    logoutBtn.id = 'logoutBtn';
    logoutBtn.textContent = 'Logga ut';

    const newUserBtn = document.createElement('button');
    newUserBtn.type = 'button'; 
    newUserBtn.id = 'newUserBtn';
    newUserBtn.textContent = 'Användare/Skapa ny';

    logoutForm.appendChild(logoutBtn);
    logoutForm.appendChild(newUserBtn);
    
    formContainer.appendChild(logoutForm);

    logoutForm.addEventListener('submit', (event) => {
        event.preventDefault(); 
        localStorage.removeItem('loggedInUser');
        console.log('Logout success');
        createLoginForm();
        updateHeaderText();
    });

    newUserBtn.addEventListener('click', () => {
        window.location.href = '/createuser';
    });
  
}

let form2 = document.querySelector('#form2');
if (form2) {
    form2.addEventListener('submit', validatePasswords);
}

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

function updateHeaderText() {
    if (document.getElementById('todoheader') && localStorage.getItem('loggedInUser')) {
        document.getElementById('todoheader').textContent = 'Du är inloggad på ToDo-List';
    } else if (document.getElementById('todoheader') && !localStorage.getItem('loggedInUser')){
        document.getElementById('todoheader').textContent = 'ToDo-List login';
    }
}