document.getElementById("loginBtn").addEventListener("click" , () => {
    
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    if (username == "admin" && password == "admin") {
        localStorage.setItem("adminLoggedIn" , "true");
    }  else {
        alert("Fel användarnamn eller lösenord");
        
    }
});

document.getElementById("logoutBtn").addEventListener("click", () => {
    localStorage.removeItem("adminLoggedIn");
});