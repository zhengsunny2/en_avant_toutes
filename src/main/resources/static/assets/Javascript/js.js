    
//topic js
const articles = [
    {
        titre: "Yoga Pilates",
        image: "../assets/images/photo8.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Yoga",
        duree: "8 min"
    },
    {
        titre: "Yoga aérien",
        image: "../assets/images/photo2.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Yoga",
        duree: "12 min"
    },
    {
        titre: "Zumba",
        image: "../assets/images/photo2.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Dance",
        duree: "15 min"
    },
    {
        titre: "Yoga Ashtanga",
        image: "../assets/images/photo1.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Yoga",
        duree: "10 min"
    },
    {
        titre: "Yoga Vinyasa",
        image: "../assets/images/photo1.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Yoga",
        duree: "10 min"
    },
    {
        titre: "Yoga Iyengar",
        image: "../assets/images/photo9.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Yoga",
        duree: "10 min"
    },
    {
        titre: "Yoga Bikram",
        image: "../assets/images/photo4.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Yoga",
        duree: "10 min"
    },
    {
        titre: "Swing Dance",
        image: "../assets/images/photo3.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Dance",
        duree: "20 min"
    },
    {
        titre: "K-pop",
        image: "../assets/images/photo9.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Dance",
        duree: "20 min"
    },
    {
        titre: "pole dance",
        image: "../assets/images/photo4.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Dance",
        duree: "20 min"
    },
    {
        titre: "Danse aérobie",
        image: "../assets/images/photo5.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Dance",
        duree: "20 min"
    },
    {
        titre: "funk",
        image: "../assets/images/photo10.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Dance",
        duree: "20 min"
    },
    {
        titre: "Formation en suspension TRX",
        image: "../assets/images/photo10.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Aerobic",
        duree: "20 min"
    },
    {
        titre: "Kickboxing",
        image: "../assets/images/photo5.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Aerobic",
        duree: "20 min"
    },
    {
        titre: "Muay Thaï Aérobie",
        image: "../assets/images/photo3.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Aerobic",
        duree: "20 min"
    },
    {
        titre: "Escalade",
        image: "../assets/images/photo6.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "sports",
        duree: "20 min"
    },
    {
        titre: "Randonnée en plein air",
        image: "../assets/images/photo10.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "sports",
        duree: "20 min"
    },
    {
        titre: "Course à pied",
        image: "../assets/images/photo7.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "sports",
        duree: "20 min"
    }
    ,
    {
        titre: "Squash",
        image: "../assets/images/photo6.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "balle",
        duree: "20 min"
    },
    {
        titre: "Tennis",
        image: "../assets/images/photo3.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "balle",
        duree: "20 min"
    },
    {
        titre: "Badminton",
        image: "../assets/images/photo7.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "balle",
        duree: "20 min"
    },
    {
        titre: "Rameur",
        image: "../assets/images/photo8.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "fitness",
        duree: "20 min"
    },
    {
        titre: "Tapis roulant",
        image: "../assets/images/photo7.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "fitness",
        duree: "20 min"
    },
    {
        titre: "Vélo spinning",
        image: "../assets/images/photo8.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "fitness",
        duree: "20 min"
    }];
const articles2 = [
    {
        titre: "Salade d'oeufs et de concombre",
        image: "../assets/images/N1.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Faible en calories et en graisse",
        duree: "20 min"
    }
    ,
    {
        titre: "Raviolis chinois",
        image: "../assets/images/N2.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Faible en calories et en graisse",
        duree: "20 min"
    },
    {
        titre: "Côtelettes d'agneau grillées au charbon de bois",
        image: "../assets/images/N3.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Faible en calories et en graisse",
        duree: "20 min"
    },
    {
        titre: "Cabillaud poêlé",
        image: "../assets/images/N4.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Sans noix",
        duree: "20 min"
    },
    {
        titre: "Smoothie aux fraises et aux fruits",
        image: "../assets/images/N5.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Sans noix",
        duree: "20 min"
    },
    {
        titre: "Salade verte olive noire",
        image: "../assets/images/N6.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Sans noix",
        duree: "20 min"
    },
    {
        titre: "Salade de millet et carottes",
        image: "../assets/images/N7.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Sans lactose",
        duree: "20 min"
    },
    {
        titre: "Salade De Crevettes Au Curry",
        image: "../assets/images/N8.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Sans lactose",
        duree: "20 min"
    },
    {
        titre: "Soupe à la citrouille",
        image: "../assets/images/N9.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Végétalien",
        duree: "20 min"
    },
    {
        titre: "Oeufs et avocat avec du pain",
        image: "../assets/images/N10.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Glucides peu fermentescibles",
        duree: "20 min"
    },
    {
        titre: "pâtes aux tomates",
        image: "../assets/images/N11.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Glucides peu fermentescibles",
        duree: "20 min"
    },
    {
        titre: "Avocat et légumes avec du pain",
        image: "../assets/images/N12.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Glucides peu fermentescibles",
        duree: "20 min"
    },
    {
        titre: "Salade verte au fromage de chèvre",
        image: "../assets/images/N13.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Sans gluten",
        duree: "20 min"
    },
    {
        titre: "Spaghetti à la sauce bolognaise aux tomates",
        image: "../assets/images/N14.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Sans gluten",
        duree: "20 min"
    },
    {
        titre: "Salade de légumes et de poitrine de poulet",
        image: "../assets/images/N15.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Sans gluten",
        duree: "20 min"
    },
    {
        titre: "Salade de fruits",
        image: "../assets/images/N16.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Original",
        duree: "20 min"
    },
    {
        titre: "Salade De Framboises Aux Noisettes",
        image: "../assets/images/N17.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Original",
        duree: "20 min"
    },
    {
        titre: "Pizza aux champignons",
        image: "../assets/images/N19.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Végétalien",
        duree: "20 min"
    },
    {
        titre: "Salade de riz aux œufs et au concombre",
        image: "../assets/images/N20.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Végétarien",
        duree: "20 min"
    },
    {
        titre: "Nouilles de riz Tom Yum",
        image: "../assets/images/N27.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Végétarien",
        duree: "20 min"
    },
    {
        titre: "Salade de poivrons et oignons",
        image: "../assets/images/N24.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Végétarien",
        duree: "20 min"
    }
];

const articles3 = [
    {
        titre: "Yoga Pilates",
        image: "../assets/images/D1.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Yoga",
        duree: "8 min"
    },
    {
        titre: "Yoga aérien",
        image: "../assets/images/D2.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Yoga",
        duree: "12 min"
    },
    {
        titre: "Zumba",
        image: "../assets/images/D2.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Dance",
        duree: "15 min"
    },
    {
        titre: "Yoga Ashtanga",
        image: "../assets/images/D1.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Yoga",
        duree: "10 min"
    },
    {
        titre: "Yoga Vinyasa",
        image: "../assets/images/D1.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Yoga",
        duree: "10 min"
    },
    {
        titre: "Yoga Iyengar",
        image: "../assets/images/D9.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Yoga",
        duree: "10 min"
    },
    {
        titre: "Yoga Bikram",
        image: "../assets/images/D4.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Yoga",
        duree: "10 min"
    },
    {
        titre: "Swing Dance",
        image: "../assets/images/D3.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Dance",
        duree: "20 min"
    },
    {
        titre: "K-pop",
        image: "../assets/images/D9.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Dance",
        duree: "20 min"
    },
    {
        titre: "pole dance",
        image: "../assets/images/D4.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Dance",
        duree: "20 min"
    },
    {
        titre: "Danse aérobie",
        image: "../assets/images/D5.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Dance",
        duree: "20 min"
    },
    {
        titre: "funk",
        image: "../assets/images/D1.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Dance",
        duree: "20 min"
    },
    {
        titre: "Formation en suspension TRX",
        image: "../assets/images/D5.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Aerobic",
        duree: "20 min"
    },
    {
        titre: "Kickboxing",
        image: "../assets/images/D5.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Aerobic",
        duree: "20 min"
    },
    {
        titre: "Muay Thaï Aérobie",
        image: "../assets/images/D3.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "Aerobic",
        duree: "20 min"
    },
    {
        titre: "Escalade",
        image: "../assets/images/D6.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "sports",
        duree: "20 min"
    },
    {
        titre: "Randonnée en plein air",
        image: "../assets/images/D7.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "sports",
        duree: "20 min"
    },
    {
        titre: "Course à pied",
        image: "../assets/images/D7.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "sports",
        duree: "20 min"
    }
    ,
    {
        titre: "Squash",
        image: "../assets/images/D6.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "balle",
        duree: "20 min"
    },
    {
        titre: "Tennis",
        image: "../assets/images/D3.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "balle",
        duree: "20 min"
    },
    {
        titre: "Badminton",
        image: "../assets/images/D7.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "balle",
        duree: "20 min"
    },
    {
        titre: "Rameur",
        image: "../assets/images/D8.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "fitness",
        duree: "20 min"
    },
    {
        titre: "Tapis roulant",
        image: "../assets/images/D7.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "fitness",
        duree: "20 min"
    },
    {
        titre: "Vélo spinning",
        image: "../assets/images/D8.jpg",
        difficulte: "&#9733;&#9733;&#9733;&#9733;",
        categorie: "fitness",
        duree: "20 min"
    }];

    function articlesAffiche(dataArray, containerId, categorie, classModifier) {
        let container = document.getElementById(containerId);
        if (!container) {
            return;
        }
        container.innerHTML = '';
        dataArray.filter(article => 
            categorie === 'all' || article.categorie === categorie
        ).forEach(article => {
            const articleHtml = `
                <div class="article ${classModifier}">
                <a href="../pages/entrainement-fiche.html" target="_blank">
                    <img src="${article.image}" alt="${article.titre}" class="large-image">
                    <div class="small-image-wrapper ${classModifier}">
                        <img src="../assets/images/video.png" alt="" class="small-image">
                    </div>
                    <div class="overlay ${classModifier}">
                        <div class="articlebg">
                            <h2 class="article-h2">${article.titre}</h2>
                            <h3 class="article-h3">difficulte: ${article.difficulte}</h3>
                            <div class="info">
                                <span>${article.categorie}</span>
                                <span><b>${article.duree}</b></span>
                            </div>
                        </div>
                    </div>
                    </a>
                </div>
            `;
            container.innerHTML += articleHtml;
        });
    }
    
    document.addEventListener('DOMContentLoaded', function() {
        articlesAffiche(articles, 'articles-container', 'all', 'style1');
        articlesAffiche(articles2, 'articles2-container', 'all', 'style2');
    articlesAffiche(articles3, 'articles3-container', 'all', 'style3');
});


