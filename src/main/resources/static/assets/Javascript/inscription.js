<<<<<<< HEAD


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




// button to login page
document.getElementById('connectpage').addEventListener('click', loginPage);
document.getElementById('newUserLink').addEventListener('click', registerPage);

// // Connect button functionality
// document.getElementById('connectButton').addEventListener('click', function() {
//     const username = document.getElementById('connectUser').value;
//     const password = document.getElementById('connectPassword').value;
// fetch('/auth/login', {
//         method: 'POST',
//         headers: { 'Content-Type': 'application/json' },
//         body: JSON.stringify({ username, password }),
//     })
//         .then(async response => {
//             if (!response.ok) {
//             const contentType = response.headers.get('content-type');
//             if (contentType && contentType.includes('application/json')) {
//                 const errorData = await response.json();
//                     throw new Error(errorData.message || 'Invalid credentials');
//                 } else {
//                     const errorText = await response.text();
//                     throw new Error(errorText || 'An unknown error occurred');
//                 }
//         }
//             return response.json();
//         })
//         .then(data => {
//              window.location.href = `/profil/${data.userId}`;
//             })
//             .catch(error => console.error('err : '+error));
// });



// Register button functionality
document.getElementById('inscrireButton').addEventListener('click', function() {
    const username= document.getElementById('inscrireUser').value;
    const password = document.getElementById('inscrirePassword').value;

    if(!username || !password) 
        return alert('Entrez username or password correct!');
    fetch('/auth/register', {
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
        alert('Inscription réussie!');
        auth.handleLoginSuccess(data.userId);
    })
    .catch(err => {
        console.error('Error:', err);
        alert(`Registration failed: ${err.message}`);
    });
    
});
=======


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




// button to login page
document.getElementById('connectpage').addEventListener('click', loginPage);
document.getElementById('newUserLink').addEventListener('click', registerPage);

// Connect button functionality
document.getElementById('connectButton').addEventListener('click', function() {
    const username = document.getElementById('connectUser').value;
    const password = document.getElementById('connectPassword').value;
fetch('/inscription/login', {
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
            if (data.token && data.userId)
                {
               localStorage.setItem('authToken', data.token);
               localStorage.setItem('userId', data.userId);
             window.location.href = `http://localhost:8080/profil/${data.userId}`;
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
        alert('Inscription réussie!');
        localStorage.setItem('authToken', data.token);
        localStorage.setItem('userId', data.userId);
        window.location.href = `http://localhost:8080/profil/${data.userId}`;
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


>>>>>>> 61f8f1577cd3b04242c45342950e6bd0f9843802
