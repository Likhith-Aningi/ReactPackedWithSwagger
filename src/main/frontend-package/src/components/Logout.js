import RestClient from '../service/RestClient';
async function Logout() {

  if (localStorage.getItem('jwt') !== null) {
    try {
      const resp = await RestClient.post('/api/logout', localStorage.getItem('jwt'));
      alert(resp.data);
    } catch (error) {
      console.error("Error occurred during logout:", error);
    } finally {
      localStorage.removeItem('jwt');
    }
    location.href = '/'
  }
}

export default Logout