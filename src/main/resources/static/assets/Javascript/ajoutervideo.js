function loadCategories() {
    fetch('http://localhost:8080/categories')
        .then(response => response.json())
        .then(data => {
            const categorySelect = document.getElementById('categorie');
            categorySelect.innerHTML = '<option value="">Select a category</option>';
            data.forEach(category => {
                const option = document.createElement('option');
                option.value = category.id;
                option.textContent = category.name;
                categorySelect.appendChild(option);
            });
        })
        .catch(error => console.error('Error fetching categories:', error));
}


function loadSubCategories(categorieId) {
    fetch(`http://localhost:8080/categories/${categorieId}/sousCategories`)
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to fetch subcategories');
        }
        return response.json();
    })
    .then(data => {
        const subCategorieSelect = document.getElementById('sousCategorie');
        subCategorieSelect.innerHTML = '<option value="">Select a SousCategorie</option>';
        data.forEach(SousCategorie => {
            const option = document.createElement('option');
            option.value = SousCategorie.id; 
            option.textContent = SousCategorie.name; 
            subCategorieSelect.appendChild(option); 
        });
    })
    .catch(error => {
        console.error('Error fetching subcategories:', error);
    });
}

// Event listener to load subcategories when a category is selected
document.getElementById('categorie').addEventListener('change', function() {
    const categorieId = parseInt(this.value, 10);  
    if (categorieId) {
        loadSubCategories(categorieId);
    } else {
        const subCategorieSelect = document.getElementById('sousCategorie');
        subCategorieSelect.innerHTML = '<option value="">Select a SousCategorie</option>';
    }
});


document.getElementById('addVideoBtn').addEventListener('click', function (event) {
event.preventDefault(); 
const userElement = document.getElementById("user");
const loggedInUser = userElement ? userElement.textContent : null;
const sousCategorieId = parseInt(document.getElementById('sousCategorie').value, 10);
const titre = document.getElementById("titre").value.trim();
const description = document.getElementById("description").value.trim();
const videoFile = document.getElementById("videoFile").files[0];
if (!titre || !description || !sousCategorieId || !videoFile) {
alert('Please fill in all fields and select a file.');
return;
}

const formData = new FormData();
formData.append("titre", titre);
formData.append("description", description);
formData.append("videoFile", videoFile);
fetch(`http://localhost:8080/${sousCategorieId}/add-video`, {
method: 'POST',
body: formData,
})
.then(response => {
    if (!response.ok) {
        throw new Error('Failed to add video.'); 
    }
    return response.json();
})
.then(responseData => {
    if (responseData.videoId) {
        alert('Video added successfully!');
       
        window.location.href = `http://localhost:8080/video/${responseData.videoId}`;
    } else {
        alert(responseData.message || 'Failed to add video.');
    }
})
.catch(error => {
    console.error('Error adding video:', error);
    alert('An error occurred while adding the video.');
});
});


window.onload = function () {
loadCategories();
};