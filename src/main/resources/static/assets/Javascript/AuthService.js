
export default class AuthService {
    static getAuthToken() {
      return localStorage.getItem('authToken');
    }
  
    static isAuthenticated() {
      const token = this.getAuthToken();
      return token !== null && token !== '';
    }
  
    static fetchProtectedResource(url) {
      const token = this.getAuthToken();
  
      if (!token) {
        alert('Veuillez vous connecter pour accéder à cette page.');
        window.location.href = '/inscription';
        return;
      }
  
      return fetch(url, {
        method: 'GET',
        headers: {
          'Authorization': `Bearer ${token}`,
        }
      }).then(response => {
        if (!response.ok) {
          if (response.status === 401) {
            alert('Session expirée, veuillez vous reconnecter.');
            window.location.href = '/inscription'; 
          } else {
            throw new Error('Une erreur s’est produite.');
          }
        }
        return response.json();
      });
    }

    static getProfileData() {
      return this.fetchProtectedResource('http://localhost:8080/profil')
        .then(data => {
          console.log('Protected data:', data);
          return data;
        })
        .catch(error => {
          console.error('Fetch error:', error.message);
        });
    }
  }
  
