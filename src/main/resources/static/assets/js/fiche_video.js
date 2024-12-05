//COMMENTAIRE
const addCommit = document.getElementById("addCommit");
const listCommit = document.getElementById("listCommit");
let score = 0;

function ajouterCommentaire() {
    if (addCommit.value === "") {
        alert("Veuillez entrer un commentaire : ");
    } else {
      
        let liContainer = document.createElement("div");
        liContainer.innerHTML = addCommit.value;
        liContainer.classList.add("divCommit");

       
        let imgUser = document.createElement('div');
        imgUser.classList.add('imgUser');

       
        let nomUser = document.createElement('p'); 
        nomUser.innerHTML = "@Johana";

      
        let dateComment = document.createElement('p');
        let currentDate = new Date();
        dateComment.innerHTML = currentDate.toLocaleString(); 
        dateComment.classList.add("dateComment");

        let ratingDisplay = document.createElement('p');
        ratingDisplay.innerHTML = `Calification: ${score} ★`; 
        ratingDisplay.classList.add("ratingDisplay");
        

    
        listCommit.appendChild(nomUser);
        listCommit.appendChild(imgUser);
        listCommit.appendChild(dateComment); 
        listCommit.appendChild(liContainer);
        liContainer.appendChild(ratingDisplay);

        addCommit.value = "";
    }
}


  const ratingContainer = document.getElementById("star-widget");
  const resultStars = document.getElementById("resultStart");
  if (ratingContainer) {
    score = 0;

    ratingContainer.addEventListener("click", (e) => { //count container
      if (e.target.name === "rate") {  //count
        score = parseInt(e.target.value);
      }
    });
  }
//SECTION VIDEO

  let imgsMiniatures = document.querySelectorAll('.flexwrap .img-item');
  let mainImage = document.querySelector('.main-image .main-img');
  
  imgsMiniatures.forEach(imgMiniature => {
      imgMiniature.onclick = () => {
          imgsMiniatures.forEach(imgItem => imgItem.classList.remove('active'));
          imgMiniature.classList.add('active');
  
          let newBackgroundImage = imgMiniature.children[0].getAttribute('src');
          document.querySelector('.main-image').style.backgroundImage = `url(${newBackgroundImage})`;
      };
  });
