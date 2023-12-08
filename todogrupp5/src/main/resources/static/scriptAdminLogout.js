let logoutBtn = document.getElementById("logoutBtn");
logoutBtn.addEventListener("click", () => {
    localStorage.removeItem('key1');
    localStorage.removeItem('key2');
});
