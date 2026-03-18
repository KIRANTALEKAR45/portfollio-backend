let editingSkillId = null;
let editingProjectId = null;
let editingExpId = null;

const BASE = "http://localhost:5050/api";


// ================= SKILLS =================
function loadSkills() {
    fetch(BASE + "/skills")
        .then(res => res.json())
        .then(data => {
            let list = document.getElementById("skillList");
            list.innerHTML = "";

            data.forEach(s => {
                list.innerHTML += `
                <li>
                    ${s.name} (${s.level})
                    <button onclick="editSkill(${s.id}, '${s.name}', '${s.level}')">Edit</button>
                    <button onclick="deleteSkill(${s.id})">Delete</button>
                </li>`;
            });
        });
}

function addSkill() {
    let name = skillName.value;
    let level = skillLevel.value;

    let method = editingSkillId ? "PUT" : "POST";
    let url = BASE + "/skills" + (editingSkillId ? "/" + editingSkillId : "");

    fetch(url, {
        method: method,
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ name, level })
    }).then(() => {
        editingSkillId = null;
        skillName.value = "";
        skillLevel.value = "";
        loadSkills();
    });
}

function editSkill(id, name, level) {
    editingSkillId = id;
    skillName.value = name;
    skillLevel.value = level;
}

function deleteSkill(id) {
    fetch(BASE + "/skills/" + id, { method: "DELETE" })
        .then(loadSkills);
}


// ================= PROJECTS =================
function loadProjects() {
    fetch(BASE + "/projects")
        .then(res => res.json())
        .then(data => {
            let list = document.getElementById("projectList");
            list.innerHTML = "";

            data.forEach(p => {
                list.innerHTML += `
                <li>
                    ${p.title} - ${p.description}
                    <button onclick="editProject(${p.id}, '${p.title}', '${p.description}')">Edit</button>
                    <button onclick="deleteProject(${p.id})">Delete</button>
                </li>`;
            });
        });
}

function addProject() {
    let title = projectTitle.value;
    let description = projectDesc.value;

    let method = editingProjectId ? "PUT" : "POST";
    let url = BASE + "/projects" + (editingProjectId ? "/" + editingProjectId : "");

    fetch(url, {
        method: method,
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ title, description })
    }).then(() => {
        editingProjectId = null;
        projectTitle.value = "";
        projectDesc.value = "";
        loadProjects();
    });
}

function editProject(id, title, description) {
    editingProjectId = id;
    projectTitle.value = title;
    projectDesc.value = description;
}

function deleteProject(id) {
    fetch(BASE + "/projects/" + id, { method: "DELETE" })
        .then(loadProjects);
}


// ================= EXPERIENCE =================
function loadExperience() {
    fetch(BASE + "/experience")
        .then(res => res.json())
        .then(data => {
            let list = document.getElementById("expList");
            list.innerHTML = "";

            data.forEach(e => {
                list.innerHTML += `
                <li>
                    ${e.role} at ${e.company}
                    <button onclick="editExperience(${e.id}, '${e.role}', '${e.company}')">Edit</button>
                    <button onclick="deleteExperience(${e.id})">Delete</button>
                </li>`;
            });
        });
}

function addExperience() {
    let role = expRole.value;
    let company = expCompany.value;

    let method = editingExpId ? "PUT" : "POST";
    let url = BASE + "/experience" + (editingExpId ? "/" + editingExpId : "");

    fetch(url, {
        method: method,
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ role, company })
    }).then(() => {
        editingExpId = null;
        expRole.value = "";
        expCompany.value = "";
        loadExperience();
    });
}

function editExperience(id, role, company) {
    editingExpId = id;
    expRole.value = role;
    expCompany.value = company;
}

function deleteExperience(id) {
    fetch(BASE + "/experience/" + id, { method: "DELETE" })
        .then(loadExperience);
}


// LOAD ALL
loadSkills();
loadProjects();
loadExperience();