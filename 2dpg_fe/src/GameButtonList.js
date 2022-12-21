import ItemButton from "./ItemButton";

function GameButtonList(props) {
  const retList = [];
  if (props.currentIsActor) {
    for (let i = 0; i < props.filmList.length; i++) {
      if (props.currentID == props.targetID) {}
      else {
        retList.push(
          <ItemButton key={3 * i} text={props.filmList[i].title}
            onClick={
              () => {
                props.setIsActor(props.currentIsActor ? false : true)
                props.setNumSteps(props.currentNumSteps + 0.5)
                props.setCurrentID(props.filmList[i].filmid)
              }
            }
          />
        );
        retList.push(<br key={3 * i + 1} />);
        retList.push(<br key={3 * i + 2} />);
      }
    }
  } else {
    for (let i = 0; i < props.actorList.length; i++) {
      retList.push(
        <ItemButton key={3 * i} text={props.actorList[i].firstname + " " + props.actorList[i].lastname}
          onClick={
            () => {
              props.setIsActor(props.currentIsActor ? false : true)
              props.setNumSteps(props.currentNumSteps + 0.5)
              props.setCurrentID(props.actorList[i].actorid)
            }
          }
        />
      );
      retList.push(<br key={3 * i + 1} />);
      retList.push(<br key={3 * i + 2} />);
    }
  }
  return <p>{retList}</p>;
}

export default GameButtonList;