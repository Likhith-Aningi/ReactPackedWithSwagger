import React, { useEffect, useState } from "react";

import RestClient from "../service/RestClient";


const Home = () => {
  const fetchData = async () => {
    try {
      const response = await RestClient.get('api');
      console.log(response);
      setData(response.data.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };
  useEffect(() => {
    fetchData();
  }, []);

  const [data, setData] = useState('loading...');
  return (
    <div>
      <h1>Home Wating for Hello and Updated </h1>
      <p>{data}</p>
    </div>
  );
};

export default Home;
