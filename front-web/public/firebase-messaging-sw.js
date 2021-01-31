importScripts('https://www.gstatic.com/firebasejs/8.2.4/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/8.2.4/firebase-messaging.js');

// https://github.com/react-boilerplate/react-boilerplate/issues/2952
const firebaseConfig = {
    apiKey: "AIzaSyCHbRm9HW2JQQcj0P76T_En5nR0P2luBGo",
    authDomain: "aula-push-bds.firebaseapp.com",
    projectId: "aula-push-bds",
    storageBucket: "aula-push-bds.appspot.com",
    messagingSenderId: "910401698613",
    appId: "1:910401698613:web:1857d9926d2a819ca4ea7c"
};

firebase.initializeApp(firebaseConfig);

const messaging = firebase.messaging();

messaging.onBackgroundMessage(function (payload) {
     console.log('sw bg message event: ', payload);
});

// O evento onMessage pertence ao contexto de Windows e não do service worker
//https://stackoverflow.com/questions/42964547/uncaught-firebaseerror-messaging-this-method-is-available-in-a-window-context
