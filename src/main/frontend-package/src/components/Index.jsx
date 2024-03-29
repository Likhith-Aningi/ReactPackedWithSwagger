import React from "react";

import { Link } from "react-router-dom";

/**
 * @author
 * @function Index
 **/

const Index = (props) => {
  return (
    <div>
      This is your Index page Go to Home
      <br></br>
       <Link to="/home">This is also home</Link>
    </div>
  );
};

export default Index;