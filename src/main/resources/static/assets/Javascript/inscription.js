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