// auth.js
function isAuthenticated() {
  return !!localStorage.getItem('userId');
}

// Update header based on login status
function updateHeader() {
  const connectBtn = document.getElementById('connect');
  if (!connectBtn) return; 

  if (isAuthenticated()) {
    connectBtn.innerText = 'Déconnexion';
    connectBtn.onclick = logout;
  } else {
    connectBtn.innerText = 'SE CONNECTER';
    connectBtn.onclick = () => (window.location.href = '/inscription');
  }
}

// Logout function
function logout() {
  localStorage.removeItem('userId');
  alert('Vous avez été déconnecté !');
  updateHeader();
  window.location.href = '/inscription';
}


function handleLoginSuccess(userId) {
  localStorage.setItem('userId', userId);
  updateHeader();
  window.location.href = `/profil/${userId}`;
}


function detectUserIdFromUrl() {
  const pathParts = window.location.pathname.split('/');
  if (pathParts.includes('profil')) {
    const userId = pathParts[pathParts.length - 1];
    if (userId && userId !== 'undefined') {
      localStorage.setItem('userId', userId);
    }
  }
}

// Update header on page load
document.addEventListener('DOMContentLoaded', function() {
  detectUserIdFromUrl();
  updateHeader();
});


window.auth = {
  isAuthenticated,
  updateHeader,
  logout,
  handleLoginSuccess
};