import React from 'react'
import './App.css'

import axios from 'axios'

class App extends React.Component {
  state = {
    phoneNumber: '',
    page: 0,
    count: 0,
    combinations: []
  }

  constructor(props) {
    super(props)

    this.handleChange = this.handleChange.bind(this)
    this.handleSubmit = this.handleSubmit.bind(this)
    this.links = this.links.bind(this)
  }

  render() {
    var pages = [];

    if (this.state.count > 0) {
      pages.push("Page links:  ");
    }

    var totalPages = Math.ceil(this.state.count / 40);

    for (let i = 1; i <= totalPages; i++) {
      pages.push(<li key={i}><a href="#dummy" onClick={() => { this.links(i)} }>{i}</a></li>);
    }

    return (
      <div>

      <br/><br/>
      <form>
        <input type="hidden" id="dummy"/>
        <label htmlFor="phoneNumber">Phone number </label>
        <input type="text" name="phoneNumber" id="phoneNumber" onChange={this.handleChange}/>
        <br/>
        <input type="button" onClick={this.handleSubmit} value="Submit"/>

        <br/><br/>
          Total number of combinations:  { this.state.count }
          <ul>
            { this.state.combinations.map(combo => <li key={combo}>{combo}</li>)}
          </ul>
          <br/>
      </form>


      {pages}

      </div>
    )
  }

  handleChange(event) {
    event.preventDefault();

    this.setState({phoneNumber : event.target.value})
  }

  handleSubmit(event) {
    event.preventDefault();

    axios.get(`http://localhost:8080/phones/combos`, {
        params: {
          phoneNumber: this.state.phoneNumber,
          page: this.state.page
        }
      })
    .then(res => {
      const combinations = res.data.list;
      const count = res.data.count;

      this.setState({ combinations : combinations });
      this.setState({ count : count });
    })
    .catch((error) => {
      if (error.response) {
        /*  Make sure you do not display more information than you need to (a potential security concern otherwise & verbose for a user) */
        console.log(error.response.data.message);
        console.log(error.response.status);
      }
    });
  }

 links(parm) {
    axios.get(`http://localhost:8080/phones/combos`, {
        params: {
          phoneNumber: this.state.phoneNumber,
          page: parm
        }
      })
    .then(res => {
      const combinations = res.data.list;
      const count = res.data.count;

      this.setState({ combinations : combinations });
      this.setState({ count : count });
    })
    .catch((error) => {
      if (error.response) {        
        /*  Make sure you do not display more information than you need to (a potential security concern otherwise & verbose for a user) */
        console.log(error.response.data.message);
        console.log(error.response.status);
      }
    });
  }
}

export default App;
