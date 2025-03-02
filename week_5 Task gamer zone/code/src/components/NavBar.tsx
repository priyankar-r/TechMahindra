import { useState } from "react";
import {
  Flex,
  IconButton,
  useDisclosure,
  Image,
  Input,
  InputGroup,
  InputLeftElement,
} from "@chakra-ui/react";
import { HamburgerIcon, SearchIcon } from "@chakra-ui/icons";
import logo from "../assets/gamers-zone-high-resolution-logo-transparent.png";
import DarkModeSwitch from "./DarkSwitch";
import Sidebar from "./Sidebar";
interface NavBarProps {
  onSearch: (query: string) => void;
}
function NavBar({ onSearch }: NavBarProps) {
  const { isOpen, onOpen, onClose } = useDisclosure();
  const [searchQuery, setSearchQuery] = useState("");
  const handleSearch = (event: React.ChangeEvent<HTMLInputElement>) => {
    const query = event.target.value;
    setSearchQuery(query);
    onSearch(query);
  };
  return (
    <Flex
      as="nav"
      bg="#1a1a1a"
      color="white"
      justify="space-between"
      align="center"
      px={4}
      py={3}
    >
      <Flex align="center" gap={3}>
        <Image src={logo} boxSize="50px" width="130px" />
      </Flex>
      <InputGroup maxW="400px" flex="1" mx={4}>
        <InputLeftElement pointerEvents="none">
          <SearchIcon color="gray.400" />
        </InputLeftElement>
        <Input
          placeholder="Search games..."
          value={searchQuery}
          onChange={handleSearch}
          variant="filled"
          bg="gray.700"
          color="white"
          _placeholder={{ color: "gray.400" }}
          _hover={{ bg: "gray.600" }}
          _focus={{ bg: "gray.600", outline: "none", borderColor: "cyan.500" }}
        />
      </InputGroup>
      <Flex align="center" gap={3}>
        <DarkModeSwitch />
        <IconButton
          aria-label="Open Menu"
          icon={<HamburgerIcon />}
          onClick={onOpen}
          variant="ghost"
          color="white"
          fontSize="1.5rem"
          _hover={{
            bg: "gray.700",
            transform: "scale(1.1)",
            transition: "0.2s",
          }}
        />
      </Flex>
      <Sidebar isOpen={isOpen} onClose={onClose} />
    </Flex>
  );
}
export default NavBar;