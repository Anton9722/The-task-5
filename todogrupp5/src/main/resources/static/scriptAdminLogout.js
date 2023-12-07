let logoutBtn = document.getElementById("logoutBtn");
logoutBtn.addEventListener("click", () => {
    localStorage.setItem("key1", null);
    localStorage.setItem("key2", null);
});