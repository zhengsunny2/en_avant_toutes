const contactForm = document.querySelector(".contactForm");

function envoyerUnMail() {
    Email.send({
        SecureToken : "222fe6c2-7b35-45f7-b140-5a0627ecfaf8",
        To: 'en.avant.toutes.jrx@gmail.com',
        From: document.getElementById("contactInputMail").value,
        Subject: "This is the subject",
        Body: "Nom de l'adhérente : " + document.getElementById("contactInputNom").value
        + "<br>Adresse mail de l'adhérente : " + document.getElementById("contactInputMail").value
        + "<br>Le message de l'adhérente : " + document.getElementById("contactTexte").value
    }).then(
        message => alert("Votre mail a bien été envoyé, merci!")
    ).catch(
        error => alert("Échec de l'envoi du mail : " + error)
    );
}

document.querySelector(".contactForm").addEventListener("submit", function(event) {
    event.preventDefault();
    envoyerUnMail();
    this.reset();
});