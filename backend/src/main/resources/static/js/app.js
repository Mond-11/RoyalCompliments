const button = document.getElementById('btn');
const messageDiv = document.getElementById('message');
const addBtn = document.getElementById('addBtn');
const inputField = document.getElementById('newText');

button.addEventListener('click', async () => {
    try {
        button.innerHTML = '<span class="spinner-border spinner-border-sm"></span> Consult the scrolls...';
        button.disabled = true;

        const response = await fetch('/api/compliment'); // Note: removed http://localhost:8080 (relative path is better)
        const text = await response.text();

        messageDiv.style.color = "";
        messageDiv.innerText = text;
    } catch (error) {
        messageDiv.innerText = "The royal messenger hath failed.";
        messageDiv.style.color = "red";
    } finally {
        button.innerText = 'Summon Another';
        button.disabled = false;
    }
});

addBtn.addEventListener('click', async () => {
    const newCompliment = inputField.value;
    if (!newCompliment) return;

    try {
        addBtn.disabled = true;
        addBtn.innerText = "Saving...";

        await fetch('/api/compliment', {
            method: 'POST',
            body: newCompliment
        });

        inputField.value = "";
        alert("Thy words have been etched into history!");
    } catch (error) {
        alert("Failed to save to the archives.");
    } finally {
        addBtn.disabled = false;
        addBtn.innerText = "Add";
    }
});