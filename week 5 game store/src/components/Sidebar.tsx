import { Drawer, DrawerBody, DrawerHeader, DrawerOverlay, DrawerContent, DrawerCloseButton, Button, useDisclosure, VStack } from "@chakra-ui/react";
function Sidebar() {
  const { isOpen, onOpen, onClose } = useDisclosure();
  return (
    <>
      <Button onClick={onOpen} fontFamily={'monospace'} colorScheme="teal" mb={4}>Open Menu</Button>
      <Drawer isOpen={isOpen} placement="left" onClose={onClose}>
        <DrawerOverlay />
        <DrawerContent>
          <DrawerCloseButton />
          <DrawerHeader fontFamily={'monospace'} >Game Categories</DrawerHeader>
          <DrawerBody>
            <VStack align="start">
              <Button fontFamily={'monospace'} variant="ghost">Action</Button>
              <Button fontFamily={'monospace'} variant="ghost">Racing</Button>
              <Button fontFamily={'monospace'} variant="ghost">Horror</Button>
              <Button fontFamily={'monospace'} variant="ghost">Strategy</Button>
            </VStack>
          </DrawerBody>
        </DrawerContent>
      </Drawer>
    </>
  );
}
export default Sidebar;