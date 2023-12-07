if(localStorage.getItem("key1")=="admin"&&localStorage.getItem("key2")=="admin"){
    const visa = document.getElementById("adminContent");
    visa.style.visibility="visible";
   
}
else{
    const message = document.createElement("h1");
    const remover = document.getElementById("adminContent");
    remover.remove();
    message.textContent="Du är inte admin! Tillgång förbjuden!";
    message.style.color="red";
    document.body.appendChild(message);
    const link = document.createElement("a");
    link.textContent="Länk till loggin";
    link.href="/";
    document.body.appendChild(link);

}


