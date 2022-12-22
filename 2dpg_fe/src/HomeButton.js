import ItemButton from "./ItemButton";

function HomeButton(props) {
    return <ItemButton
        text='&deg;&deg; RESET'
        buttonClassName='homeBut'
        onClick={
            () => {
                props.setIsActor(true)
                props.setNumSteps(0)
                props.setInitialID(Math.floor(Math.random() * 200) + 1)
                props.setTargetID(Math.floor(Math.random() * 200) + 1)
            }
        }
    />
}

export default HomeButton;