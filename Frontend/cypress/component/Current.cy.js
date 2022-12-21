import Current from "../../src/Current"

describe('Current.cy.js', () => {
  it('When we look at a film whose ID is the target ID, show the film.', () => {
    cy.mount(<Current currentID={1} targetID={1} itemName="Agoodfilm" isActor={false} />)
    cy.get('[data-cy=Current]').should('have.text', 'The current film is Agoodfilm. Agoodfilm stars the following actors:')
  })
  it('When we look at a film whose ID is not the target ID, show the film.', () => {
    cy.mount(<Current currentID={1} targetID={2} itemName="Agoodfilm" isActor={false} />)
    cy.get('[data-cy=Current]').should('have.text', 'The current film is Agoodfilm. Agoodfilm stars the following actors:')
  })
  it('When we look at an actor whose ID is the target ID, show win condition.', () => {
    cy.mount(<Current currentID={1} targetID={1} itemName="Joe Bloggs" isActor={true} />)
    cy.get('[data-cy=Current]').should('have.text', 'The current actor is Joe Bloggs. You win!')
  })
  it('When we look at an actor whose ID is not the target ID, show the actor.', () => {
    cy.mount(<Current currentID={1} targetID={2} itemName="Joe Bloggs" isActor={true} />)
    cy.get('[data-cy=Current]').should('have.text', 'The current actor is Joe Bloggs. Joe Bloggs stars in the following films:')
  })
})
