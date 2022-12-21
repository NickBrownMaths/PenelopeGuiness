import Counter from "../../src/Counter.js"

describe('Counter.cy.js', () => {
  it('displays a number', () => {
    cy.mount(<Counter numSteps={42} />)
    cy.get('p').should('have.text', 'You have made 42 links.')
  })
})