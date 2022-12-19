// Style
import './App.css';

// React Sub Components
import TitleLine from './TitleLine.js';
import Initial from './Initial.js';
import Target from './Target';
import Counter from './Counter';
import Current from './Current';
import Button from './ItemButton';
import GameButtonList from './GameButtonList';

import { useEffect, useState } from 'react';
import { useFetch } from 'react-async'


// Helper Functions
function camelCase(str) {
  str = str.toLowerCase();
  str = str[0].toUpperCase() + str.substring(1);
  return str;
}
function generalCamelCase(str) {
  let retString = "";
  let strArray = str.split(" ");
  for (let i = 0; i < strArray.length; i++) {
    if (i > 0) retString = retString + " ";
    retString = retString + camelCase(strArray[i]);
  }
  return retString
}

function App() {
  const fetcher = () => {
    fetch("http://localhost:8080/home/getActor/" + initialID)
      .then((response) => response.json())
      .then((actor) => setInitialActor(actor));
    fetch("http://localhost:8080/home/getActor/" + targetID)
      .then((response) => response.json())
      .then((actor) => setTargetActor(actor));

    if (isActor) {
      console.log("Fetching an actor")
      fetch("http://localhost:8080/home/getActor/" + currentID)
        .then((response) => response.json())
        .then((actor) => setCurrentActor(actor));
      fetch("http://localhost:8080/home/allFfromA/" + currentID)
        .then((response) => response.json())
        .then((list) => setFilmList(list));

    } else {
      console.log("Fetching an Film")
      fetch("http://localhost:8080/home/getFilm/" + currentID)
        .then((response) => response.json())
        .then((film) => setCurrentFilm(film));
      fetch("http://localhost:8080/home/allAfromF/" + currentID)
        .then((response) => response.json())
        .then((list) => setActorList(list));
    }
  }

  const [initialID, setInitialID] = useState(Math.floor(Math.random() * 200) + 1);
  const [targetID, setTargetID] = useState(Math.floor(Math.random() * 200) + 1);
  const [currentID, setCurrentID] = useState(initialID);
  const [initialActor, setInitialActor] = useState("");
  const [targetActor, setTargetActor] = useState("");
  const [currentActor, setCurrentActor] = useState("");
  const [currentFilm, setCurrentFilm] = useState("");
  const [isActor, setIsActor] = useState(true);
  const [numSteps, setNumSteps] = useState(0);
  const [filmList, setFilmList] = useState(0);
  const [actorList, setActorList] = useState(0);

  // Fetch requests
  useEffect(() => { fetcher(); }, [currentID])

  // Make strings for the name of the current actor/film
  let currentName;
  if (isActor) {
    currentName = currentActor.firstname + " " + currentActor.lastname
  } else {
    currentName = currentFilm.title;
  }

  // Render
  return (
    <div className='vertcenter'>
      <TitleLine />
      <Initial actorName={initialActor.firstname + " " + initialActor.lastname} />
      <Target actorName={targetActor.firstname + " " + targetActor.lastname} />
      <Counter numSteps={Math.floor(numSteps)} />
      <Current currentID={currentID} targetID={targetID} itemName={currentName} isActor={isActor} />
      <GameButtonList
        setIsActor={setIsActor}
        setCurrentID={setCurrentID}
        setNumSteps={setNumSteps}
        currentIsActor={isActor}
        currentNumSteps={numSteps}
        currentID={currentID}
        targetID={targetID}
        currentActor={currentActor}
        currentFilm={currentFilm}
        filmList={filmList}
        actorList={actorList}
        numButs={9} />
    </div>
  );
}

export default App;