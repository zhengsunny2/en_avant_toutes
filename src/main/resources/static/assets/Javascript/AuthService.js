class AuthService {
  static getAuthToken() {
    return localStorage.getItem('authToken');
  }

  static isAuthenticated() {
    const token = this.getAuthToken();
    return !!token;
  }

  static logout() {
    localStorage.removeItem('authToken');
    localStorage.removeItem('userId');
    alert('Déconnexion réussie.');
    window.location.href = '/inscription';
  }

  static fetchProtectedResource(url) {
    const token = this.getAuthToken();
    if (!token) {
      alert('Veuillez vous connecter pour accéder à cette page.');
      window.location.href = '/inscription';
      return Promise.reject(new Error('Not authenticated.'));
    }

    return fetch(url, {
      method: 'GET',
      headers: {
        'Authorization': `Bearer ${token}`,
      },
    }).then(response => {
      if (!response.ok) {
        if (response.status === 401) {
          alert('Session expirée, veuillez vous reconnecter.');
          this.logout();
        }
        throw new Error('Erreur lors de la récupération des données.');
      }
      return response.json();
    });
  }

  static getProfilData(userId) {
    return this.fetchProtectedResource(`http://localhost:8080/profil/${userId}`);
  }
}
