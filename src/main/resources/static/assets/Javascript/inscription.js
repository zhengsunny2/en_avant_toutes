const users = JSON.parse(localStorage.getItem('users')) || [];

function saveUser(user, password) {
    users.push({ user, password });
    localStorage.setItem('users', JSON.stringify(users));
}

// Click to switch to registration page
document.getElementById('newUserLink').addEventListener('click', function () {
    document.getElementById('connectPage').style.display = 'none';
    document.getElementById('inscrirePage').style.display = 'block';
});

// Click to switch to connection page
document.getElementById('connectpage').addEventListener('click', function () {
    document.getElementById('connectPage').style.display = 'block';
    document.getElementById('inscrirePage').style.display = 'none';
});

// Connect button functionality
document.getElementById('connectButton').addEventListener('click', function() {
    const user = document.getElementById('connectUser').value;
    const password = document.getElementById('connectPassword').value;
    const foundUser = users.find(u => u.user === user && u.password === password);
    
    if (foundUser) {
        alert(`Bienvenue, ${user}!`);
        localStorage.setItem('currentUser', user);  // Save current user to localStorage
        window.location.href = '../pages/profil.html';  // Redirect to profile page
    } else {
        alert('Id et mot de pass ne sont pas correct!');
    }
});



// Register button functionality
document.getElementById('inscrireButton').addEventListener('click', function() {
    const user = document.getElementById('inscrireUser').value;
    const password = document.getElementById('inscrirePassword').value;
    
    if (user && password) {
        // Check if user already exists
        const existingUser = users.find(u => u.user === user);
        if (existingUser) {
            alert('Cet utilisateur existe déjà!');
        } else {
            saveUser(user, password);
            alert(`User ${user} s'est inscrit avec succès!`);
            localStorage.setItem('currentUser', user);  // Save current user to localStorage
            window.location.href = '../pages/profil.html';  // Redirect to profile page
        }
    } else {
        alert('Entre votre id et mot de pass!');
    }
});

// Update header based on login status
function updateHeader() {
    const currentUser = localStorage.getItem('currentUser');
    const connectElement = document.getElementById('connect');
    
    if (currentUser) {
        connectElement.innerText = 'Déconnexion'; 
        connectElement.onclick = logout;  // Bind logout function
    } else {
        connectElement.innerText = 'SE CONNECTER'; 
        connectElement.onclick = function() { window.location.href = '../pages/entrainement.html'; };  // Redirect to login page
    }
}

// Logout functionality
function logout() {
    localStorage.removeItem('currentUser');  // Remove current user from localStorage
    window.location.href = '../pages/entrainement.html';  // Redirect to homepage after logout
    alert('Vous avez quitté!');
}

// Update header on page load
document.addEventListener('DOMContentLoaded', function() {
    updateHeader();  // Update header when the page loads
});
