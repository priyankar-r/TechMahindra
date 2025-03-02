import { HStack, Image, Text } from "@chakra-ui/react";
import logo from '../assets/ghost-games-logo-black-and-white.png';
import DarkSwitch from "./DarkSwitch";
function NavBar() {
  return (
    <HStack justifyContent="space-between" padding="15px">
      <HStack>
        <Image src={logo} boxSize={50} />
        <Text fontSize="lg" fontFamily={'cursive'} fontWeight="bold">Game Store</Text>
      </HStack>
      <DarkSwitch />
    </HStack>
  );
}
export default NavBar;