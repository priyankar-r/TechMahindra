import { ChakraProvider } from "@chakra-ui/react";
import theme from "./Theme";
import NavBar from "./components/NavBar";
import GameCard from "./components/gamecard";
import Footer from "./components/Footer";
import Sidebar from "./components/Sidebar";
import { useState } from "react";
function App() {
  const [searchQuery, setSearchQuery] = useState("");
  return (
    <ChakraProvider theme={theme}>
      <NavBar onSearch={setSearchQuery} />
      <Sidebar isOpen={false} onClose={() => {}} />
      <GameCard searchQuery={searchQuery} />
      <Footer />
    </ChakraProvider>
  );
}
export default App;