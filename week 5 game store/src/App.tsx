import { Grid, GridItem } from "@chakra-ui/react";
import NavBar from "./components/NavBar";
import Gamecard from "./components/gamecard";
import Footer from "./components/Footer";
import Sidebar from "./components/Sidebar";
function App() {
  return (
    <>
      <Grid templateAreas={`"nav nav" "side main" "footer footer"`} gap={4}>
        <GridItem area="nav" p={4} bg="#ed7412" color="white">
          <NavBar />
        </GridItem>
        <GridItem area="side" p={4} bg="#f84de0">
          <Sidebar />
        </GridItem>
        <GridItem area="main" p={4}>
          <Gamecard />
        </GridItem>
        <GridItem area="footer">
          <Footer />
        </GridItem>
      </Grid>
    </>
  );
}
export default App;