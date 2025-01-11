
    AuthService.getProfilData(userId)
      .then(data => {
        if (data) {
          console.log("User profile data:", data);
          document.getElementById('profileName').innerText = data.username || "Unknown User";
        }
      })
      .catch(error => {
        console.error("Error fetching profile:", error.message);
        alert("Erreur lors de la récupération des données du profil !");
        window.location.href = '/inscription';
      });

  