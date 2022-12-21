import TitleLine from "../../src/TitleLine"

describe('TitleLine.cy.js', () => {
  it('displays the title', () => {
    cy.mount(<TitleLine />)
    cy.get('h1').should('have.text', '°° Two Degrees of Penelope Guiness')
  })
})