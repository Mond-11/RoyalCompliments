const button = document.getElementById('btn');
const messageDiv = document.getElementById('message');
const authorDiv = document.getElementById('author');

const addBtn = document.getElementById('addBtn');
const inputField = document.getElementById('newText');

button.addEventListener('click', async () => {
    try {
        button.innerHTML = '<span class="spinner-border spinner-border-sm"></span> Consulting...';
        button.disabled = true;

        const response = await fetch('/api/compliment');
        const data = await response.json();

        messageDiv.innerText = `"${data.text}"`;
        authorDiv.innerText = `- ${data.author}`;

    } catch (error) {
        messageDiv.innerText = "The library is on fire.";
        authorDiv.innerText = "";
    } finally {
        button.innerText = 'Consult Again';
        button.disabled = false;
    }
});

addBtn.addEventListener('click', async () => {
    const textVal = inputField.value;
    const authorVal = document.getElementById('newAuthor').value;

    if (!textVal) return;

    try {
        addBtn.disabled = true;
        addBtn.innerText = "Saving...";

        const dataToSend = {
            text: textVal,
            author: authorVal
        };

        await fetch('/api/compliment', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dataToSend)
        });

        inputField.value = "";
        document.getElementById('newAuthor').value = "";

        alert("Thy wisdom hath been recorded!");

    } catch (error) {
        console.error(error);
        alert("Failed to save to the archives.");
    } finally {
        addBtn.disabled = false;
        addBtn.innerText = "Add to Archives";
    }
});