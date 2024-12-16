
const authToken = localStorage.getItem('authToken');

fetch('http://localhost:8080/profil', {
    method: 'GET',
    headers: {
        'Authorization': `Bearer ${authToken}` 
    }
})
.then(response => {
    if (!response.ok) {
        console.error('Failed to fetch protected resource');
    }
    return response.json();
})
.then(data => console.log(data))
.catch(error => console.error(error));
