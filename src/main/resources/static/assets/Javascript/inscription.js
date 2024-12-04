/*
const users = JSON.parse(localStorage.getItem('users')) || [];

function saveUser(username, password) {
    users.push({ username, password });
    localStorage.setItem('users', JSON.stringify(users));
}
*/
//rigister
function registerPage() {
    document.getElementById('connectPage').style.display = 'none';
    document.getElementById('inscrirePage').style.display = 'block';
}

// login
function loginPage() {
    document.getElementById('connectPage').style.display = 'block';
    document.getElementById('inscrirePage').style.display = 'none';
}

// button to register page
document.getElementById('newUserLink').addEventListener('click', registerPage);

// button to login page
document.getElementById('connectpage').addEventListener('click', loginPage);

// Connect button functionality
document.getElementById('connectButton').addEventListener('click', function() {
    const username = document.getElementById('connectUser').value;
    const password = document.getElementById('connectPassword').value;
fetch('http://localhost:8080/inscription/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password }),
    })
        .then(async response => {
            if (!response.ok) {
            const contentType = response.headers.get('content-type');
            if (contentType && contentType.includes('application/json')) {
                const errorData = await response.json();
                    throw new Error(errorData.message || 'Invalid credentials');
                } else {
                    const errorText = await response.text();
                    throw new Error(errorText || 'An unknown error occurred');
                }
        }
            return response.json();
        })
        .then(data => {
            if (data.token,data.redirect)
                {
                    if (readCookie('auth-token-vod')==null) 
                    {
                        createCookie('auth-token-vod',data.token,2);
                    }
             localStorage.setItem('authToken', data.token);
            alert(`Bienvenue, ${username}!`);
            window.location.href = data.redirect;
                }
                else if (data.status==404)
                {
                    alert("pas d'user avec ce couple identifiant / mot de passe");
                }
            })
            .catch(error => console.error('err : '+error));
});



// Register button functionality
document.getElementById('inscrireButton').addEventListener('click', function() {
    const username= document.getElementById('inscrireUser').value;
    const password = document.getElementById('inscrirePassword').value;

    if(!username || !password) 
        return alert('Entrez username or password correct!');
    fetch('http://localhost:8080/inscription/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
    })
    .then(async response => {
        const contentType = response.headers.get('content-type');
        if (contentType && contentType.includes('application/json')) {
            return await response.json();
        } else {
            const text = await response.text();
            throw new Error(`Server response: ${text}`);
        }
    })
    .then(data => {
        console.log('Parsed JSON Data:', data);
        localStorage.setItem('authToken', data.token);
        alert('Inscription réussie!');
        window.location.href = 'http://localhost:8080/video';
    })
    .catch(err => {
        console.error('Error:', err);
        alert(`Registration failed: ${err.message}`);
    });
    
});
// Update header based on login status
function updateHeader() {
    const authToken = localStorage.getItem('authToken');
    const connectElement = document.getElementById('connect');

    if (authToken) {
        connectElement.innerText = 'Déconnexion';
        connectElement.onclick = logout;
    } else {
        connectElement.innerText = 'SE CONNECTER';
        connectElement.onclick = () => (window.location.href = '/inscription');
    }
}

// Logout functionality
function logout() {
    localStorage.removeItem('authToken');
    alert('Vous avez été déconnecté!');
    updateHeader();
    window.location.href = '/inscription';
}

// Update header on page load
document.addEventListener('DOMContentLoaded', function() {
    updateHeader();  // Update header when the page loads
});


  //+ d'infos sur les cookies en javascript : https://www.quirksmode.org/js/cookies.html
  function createCookie(name, value, days) {
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));  
        var expires = "; expires=" + date.toGMTString();
    } else {
        var expires = "";
    }
    document.cookie = name + "=" + value + expires + "; path=/";
}


function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
}

function eraseCookie(name) {
    createCookie(name, "", -1);
}