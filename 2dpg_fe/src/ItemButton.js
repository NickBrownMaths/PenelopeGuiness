function ItemButton(props) {
  return (
    <button data-cy='ItemButton' className='itemButton' onClick={props.onClick}>
      {props.text}
    </button>
  )
}

export default ItemButton;