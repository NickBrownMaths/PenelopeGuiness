import Initial from "../../src/Initial.js"

describe('Initial.cy.js', () => {
  it('displays the initial actor', () => {
    cy.mount(<Initial actorName="Joe Bloggs" />)
    cy.get('p').should('have.text', 'You started at Joe Bloggs.')
  })
})