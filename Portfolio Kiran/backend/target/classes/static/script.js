const BASE = "http://localhost:5050/api";

// ================= SKILLS =================
function loadSkills() {
    fetch(BASE + "/skills")
        .then(res => res.json())
        .then(data => {
            let container = document.getElementById("skillsContainer");
            container.innerHTML = "";

            data.forEach(skill => {
                container.innerHTML += `
                    <div class="card">
                        <h3>${skill.name}</h3>
                        <div class="progress">
                            <div style="width:${skill.level}%"></div>
                        </div>
                    </div>
                `;
            });
        });
}

// ================= PROJECTS =================
function loadProjects() {
    fetch(BASE + "/projects")
        .then(res => res.json())
        .then(data => {
            let container = document.getElementById("projectsContainer");
            container.innerHTML = "";

            data.forEach(project => {
                container.innerHTML += `
                    <div class="card">
                        <h3>${project.title}</h3>
                        <p>${project.description}</p>
                    </div>
                `;
            });
        });
}

// ================= EXPERIENCE =================
function loadExperience() {
    fetch(BASE + "/experience")
        .then(res => res.json())
        .then(data => {
            let container = document.getElementById("experienceContainer");
            container.innerHTML = "";

            data.forEach(exp => {
                container.innerHTML += `
                    <div class="card">
                        <h3>${exp.role}</h3>
                        <p>${exp.company}</p>
                    </div>
                `;
            });
        });
}

// LOAD ALL
loadSkills();
loadProjects();
loadExperience();