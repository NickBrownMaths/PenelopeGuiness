function Current(props) {
  let itemType;
  let listHeader;
  if (props.isActor == true) {
    itemType = "actor";
    if (props.currentID == props.targetID) {
      listHeader = "You win!";
    } else {
      listHeader = props.itemName + " stars in the following films:";
    }
  } else {
    itemType = "film";
    listHeader = props. itemName + " stars the following actors:";
  }
  return (
    <p data-cy="Current">The current {itemType} is {props.itemName}. {listHeader}</p>
  )
}

export default Current;

