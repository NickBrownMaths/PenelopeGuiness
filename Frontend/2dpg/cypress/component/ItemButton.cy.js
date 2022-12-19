import ItemButton from "../../src/ItemButton.js"

describe('Button.cy.js', () => {
  it('displays a button', () => {
    cy.mount(<ItemButton text={'Test Button'} onClick={['']}/>)
    cy.get('[data-cy=Button]').should('have.attr', 'onClick')
  })
})